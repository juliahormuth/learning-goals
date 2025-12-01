# Autenticacao

## Session vs JWT

### Session

- O cliente envia credenciais ao servidor, servidor verifica estas credenciais e se forem válidas, ele cria uma nova sessao. Em seguida, armezena os dados da sessao em um banco de dados ou em um cache como o Redis. Os dados podem incluir: Id do usuário, tempo de expiracao e outros metadados. O servidor envia de volta uma resposta com um ID de sessao exclusiva (Geralmente em forma de Cookie).
- Nas requests subsequentes, o cliente envia automaticamente a requisicao contendo o cookie de sessao única retornado na primeira request.
- O servidor pega o Id da sessao e procura os dados da sessao no armanezamento e usa esses dados para autenticar e processar a solicitacao.
- O ponto principal é: A autenticacao baseada em sessao, o servidor é responsável por criar e armazenar os dados da sessao. Em seguida, ele usa o Id da sessao como uma chave para recuperar estes dados em solicitacoes futuras.

#### Vantagens: 
- Revogar uma sessao é simples, já que seus dados sao armazenados no servidor, o servidor pode simplesmente excluir ou invalidar uma sessao a qualquer momento. No entendo, em um sistema distribuído, em que seu aplicativo é executado em vários servidores, todos estes servidores precisam acessar o mesmos dados da sessao. Isso geralmente é obtido usando um armazenamento de sessao centralizado em que todos os servidores podem  acessar, como o Redis ou um banco de dados SQL. Embora funcione bem, isso adiciona alguma complexidade e potencia latencia a cada solicitacao, pois o servidor precisa fazer uma viagem separada ao armazenamento da sessao.

### JWT

- O cliente envia suas credenciais de login ao servidor, o servidor as verifica e se forem válidas, gera um JWT. O servidor atribui o JWT com uma chave secreta. Essa assinatura garante a integridade do token, impedindo sua adulteracao.
O servidor entao envia o JWT de volta para o cliente, normalmente no corpo da resposta. O cliente armazena o JWT em um armazenamento local ou em um Web cookie, e em solicitacoes subsequentes, o cliente envia o JWT nos cabecalhos da solicitacao. O servidor verifica a assinatura do JWT e se for válida, o servidor confia nos dados do token e os usa para a autorizacao de autenticacao.

#### Diferenca crucial
- É que com os JWTs, o servidor nao armazena nenhum estado da sessao. Todos os dados necessarios estao contidos no proprio token que é armazenado no proprio cliente, isso torna os JWT sem estado.

#### Métodos de assinatura
- HMAC: Mesma chave secreta é usada para assinar e verificar o token. É mais simples e eficiente, mas exige o compartilhamento da chave secreta com qualquer servico que precise verificar o token, o que pode ser um risco de seguranca.

- RSA e ECDSA: Eles usam uma chave privada para assinar o token e uma chave pública para verificá-lo. Isso permite uma arquitetura mais segura, na qual a chave primária é mantida em segredo e usada somente para assinatura, enquanto qualquer servico pode verificar o token usando a chave pública. No entendo, isso adiciona alguma complexidade e sobrecarga computacional em comparacao com o HMAC.

#### Quando usar HMAC?
- Se voce tiver um monolito ou confiar em todos os servicos do seu sistema, o HMAC pode ser suficiente.

#### Quando usar RSA ou ECDSA?
- Arquitetura de Microsservicos ou se precisar compartilhar JWTs entre servicos de terceiros nao confiaveis, o RSA ou o ECDSA fornecem uma solucao mais segura.

#### Desafios
- Um desafio com os JWTs é lidar com a expiracao do token. Se um token for roubado, ele poderá ser usado até expirar. Para mitigar isso, voce pode usar tokens de atualizacao em combinacao com tokens de acesso de curta duracao.
- O token de acesso é o JWT real usado para autenticacao em cada solicitacao. Possui um prazo de validade curto, geralmente de 15 minutos. O token de atualizacao, por outro lado, tem um tempo de expiracao muito maior, talvez dias ou semanas.
- Quando o token de acesso expira, em vez de exigir que o usuário faca o login novamente, o cliente pode enviar o token de atualizacao para um endpoint de token especial no servidor. O servidor verifica se o token de atualizacao é válido e se nao foi revogado. Se tudo estiver correto, o servidor emite um novo token de acesso. Esse processo ocorre em segundo plano sem exigir interacao do usuário (seguranca e experiencia do usuário). 
Os tokens de acesso de curta duracao limitam as janelas de possíveis usos indevidos, caso um token seja roubado. Enquanto o token de atualizacao de longa duracao permite que os usuários permaneceram autenticados por um longo período sem precisar fazer login repetidamente.
- É importante observar que o token de atualizacao só é enviado quando o token de acesso expira, e nao a cada requisicao. Já o token de acesso é enviado em todas as solicitacoes que exigem autenticacao.


## Quando usar um ou outro

### Sessao
- Boa opcao quando voce precisa revogar sessoes instantaneamente. Se um usuário reportar que sua conta foi comprometida, voce pode invalidar imediatamente a sessao dele no lado do servidor.
- Também é uma boa opcao quando voce ja tem um repositorio de dados centralizados para outros fins. Neste caso, pode aproveitar a infraestrutura existente para o armazenamento de sessoes. Mas é bom lembrar que o armazenamento centralizado adiciona latencia a cada solicitacao, pois o servidor precisa buscar os dados da sessao no armazenamento. Por fim, as sessoes mantem dados confidenciais no `servidor`, ou pode representar uma vantagem de seguranca.

### JWT
- Por outro lado, JWTs sao uma opcao quando voce precisa de uma arquitetura sem estado, ja que os JWTs armazenam todos os dados necessários no proprio token. Seu servdor nao precisa menter o controle das sessoes na memória ou em um banco de dados. Isso facilita muito o dimesionamento horizontal do aplicativo em vários servidores.
- Também sao úteis quando voce precisa compartilhar dados de autenticacao com outros servicos. Por exemplo, em uma arquitetura de microsservicos, um JWT gerado por um servico de autenticacao pode ser verificado e considerado confiável por outros servicos, sem a necessidade de entrar em contato com o servico de autenticacao em cada solicitacao.
- Se optar por JWT, considera implementar tokens de atualizacao para equilibrar a seguranca e experiencia do usuário.