# Stream API
- Permite pegar uma colecao e realizar operacoes para obtencao de um resultado.

1. filter (filtrar)
2. map (mapear)
3. reduce (reduzir)
4. sorted (ordenar)
5. collect/Collectors (agrupar)
6. contar, somar, estatísticas, etc.

- Código mais limpo, poderoso na manipulacao de dados, pode transformar um Stream em `parallelStream()` e proessar em múltiplos núcleos.

## Como ocorrem?

- Criacao de uma colecao de array e etc.
- Operacoes intermediárias (lazy) que só executam quando uma operacao terminal é chamada (Ex: filter, map, sorted).
- Operacoes terminais (collect, forEach, count, reduce).

## Tipos de Stream

### Stream<T>
- Para objetos no geral (filter, map, flatMap, sorted, distinct, etc)

### Streams primitivas
- Como o IntStream (operacoes especiais como sum(), average(), min(), max(), summaryStatistics())

### LongStream
- Para Long e útil para operacoes numéricas pesadas.

### DoubleStream
- Trabalha com double, muito usado para cálculos e estatísticas.

### ParallelStream
- Utiliza múltiplas threads para processar mais rápido — porém deve ser usada com cuidado.