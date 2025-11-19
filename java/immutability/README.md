# Imutabilidade

## Características:
- Classe e atributos `final`
- Sem método `set`
- Propriedades inseridas apenas via construtor.

## Vantagens:
- Código mais rápido, pois o compilador sabe que esse objeto nao vai mudar.
- Reduz complexidade do código
- Aumenta a seguranca em ambientes `multi-threads`
- Previne de bugs que ocorrem pela acao inesperada da mudanca do seu objeto

## Dica:
- Sempre que voce tem uma classe que nao precisa ser modificada, considere torná-la imutável.