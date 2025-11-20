# Collections API do Java

## List
Mais utilizado, oferencendo métodos de adicao de elementos, subtracao e etc. Permite elementos `duplicados`. Bom para ordem e acesso por índice.
- ArrayList: Mais usada e rápida para leitura.
- LinkedList: Melhor para muitas insercoes e remocoes no meio da lista.
(Ex: Lista de produtos de um carrinho).

## Set
Parecido com o List, mas com a premissa de que `elementos NAO se repetem`.
Ele pode ou nao manter a ordem e é muito eficiente.
- HashSet: Mais rápido, sem ordem garantida.
- LinkedHashSet: Mantém a ordem de insercao.
- Treeset: Mantém os elementos ordenados automaticamente.
É bom para garantir nao duplicatas, quando a ordem nao é importante (ou precisa ser ordenada automaticamente) e bom para verificar se um item já existe (Permissoes de um usuário por exemplo).

## Map
Premissa de elemento `chave e valor`. Neste caso, cada chave é única. Os valores podem ser duplicados. Muito eficiente para buscas por chave.
- HashMap: Mais utilizado e rápido, sem ordenação
- LinkedHashMap: Mantém ordem de inserção
- TreeMap: Ordena pelas chaves
É bom quando voce precisa associar informacoes, para buscar rápidas por chave.
Também é bom para Caches (ID -> Objeto), configuracoes (Valor -> Chave).