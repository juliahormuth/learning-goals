# JPA
- Isso tudo abaixo é algo que nao precisamos configurar no Spring Data JPA, mas é algo que acontece no JPA. Pois o Spring Data JPA é uma abstracao do JPA. Na hierarquia:
4. Spring Data JPA
3. Java Persistance API (JPA)
2. Hibernate
1. JDBC

## Entity
- Entity é um objeto/classe java que será mapeado para uma tabela do seu banco relacional e salva no mesmo.

## Entity Manager
- Gerenciador de entidades que vai gerenciar a Entidade. É uma interface dentro do java responsável por gerenciar as entidades. Todas as entidades criadas serao gerenciadas por ele. Ou seja, quem for salvo ou persistido, quem fará isso é o Entity Manager. É ele quem vai executar operacoes na entidade correta.

## Entity Manager Factory
- Cria o Entity Manager e é gerenciado pela Persistance (persistance.xml).

## Persistance (Unidade de persistencia)
- Cria uma Entity Manager Factory que poderá criar vários Entitys Managers na sua aplicacao que gerenciarao todas as Entitys da sua aplicacao.

## Persistance Context 
- É como um cache onde essas entitys serao temporariamente armazenadas e gerenciadas. O Entity Manager interage com o Persistance Context para obter as entidades.

Ex: Quando a Entity foi criada, ela é armazenada no Contexto de persistencia, clicamos em persist e o Entity Manager vai chamar o persist e tentará salvar essa entidade. O Entity Manager nao pode interagir diretamente com o banco de dados, entao ele terá um provedor. Neste caso, o Entity Manager vai atribuir a tarefa de interagir com o banco de dados para o Hibernate. Nesse caso, o Hibernate criará as consultas SQL e acessará o banco de dados. O Entity Manager também criará transacoes pelo Entity Transaction. A Transacao será criada e todas as operacoes do Banco de dados acontecerao dentro dessa transacao especifica que é gerenciada pelo Entity Manager.

## Ciclo de vida da Entidade
`Transient`: A partir do momento que uma nova entidade é criada com `new Entity()` por exemplo (entidade nova que ainda nao é gerenciada pelo Entity Manager).
`Managed`: Ao chamarmos `persist()`a entidade passa a ser gerenciada e será associado ao `Persistance Context` (Esse estado também é chamado de Estado de persistencia ou `Persistente`).
Quando fizermos o commite da transacao, seus dados serao adicionados no banco de dados (`flush()`). 
Caso estejamos procurando uma entitade no banco e ela existir, ao pegarmos ela, ela também está em um estado de `Managed`.
`Detached`: Entidades que antes estavam no Persistence Context, mas agora nao sao mais gerenciadas pelo Entity Manager, quando voce desanexa, fecha ou limpa (detach, close ou clear), ela nao será mais gerenciada pelo contexto de persistencia e ficará desanexada. Para move-lá novamente para o `Managed`voce terá que usar o `merge()` (operacao de mesclagem).
`Removed`: Quando sua entidade é marcada para exclusao, mas ela ainda está dentro do Persistance Context e voce chamará o remove(), assim que concluida após o flush(), ela sera removida do Banco de dados e posteriormente muda do estado `Managed` para `Removed`.

### Exemplos:
- `Transient` para `Persistente`: Chamando persist() ou save().
- `Persistente` para `Detached`: Chamando detach() ou quando o Entity Manager fecha.
- `Persistente` para `Removed`: Chamando remove().
- `Detached` para `Persistente`: Chamando merge().