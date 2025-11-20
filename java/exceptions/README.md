# Exceptions
- São eventos indesejados que acontecem durante a execução do programa (ex.: arquivo não encontrado, valor inválido, divisão por zero, etc.).
Quando algo dá errado, o Java lança uma exception para evitar que o programa continue com dados quebrados.

## Checked Exceptions (erros previsíveis e recuperáveis)
- Sao verificadas em tempo de compilacao.
- Voce deve tratá-las com `try/catch` ou `throws` na assinatura do método.
- Representam erros `esperados` durante a execução.
- O java te obriga a trata-las.

### Exemplos:
- IOException
- SQLException
- FileNotFoundException
- ParseException

`
public void lerArquivo() throws IOException {
    FileReader reader = new FileReader("arquivo.txt");
}
`

### Quando usar? 
- Quando o erro é recuperável.
- Quando faz sentido obrigar o desenvolvedor a lidar com o problema.

## Unchecked Exceptions (Runtime Exceptions -> Bugs ou erros lógicos)
- Verificadas em tempo de execução, não na compilação.
- O Java não obriga você a tratá-las.
- Geralmente representam erros de programação.

### Exemplos:
- NullPointerException
- IllegalArgumentException
- IndexOutOfBoundsException
- ArithmeticException

Ex: `int x = 10 / 0; // ArithmeticException`

- O programa compila normalmente, mas quebra em tempo de execução.

### Quando usar? 
- Para erros que normalmente indicam bug do programador.
- Para situações das quais o código não consegue se recuperar.
- Ex: nulo inesperado, índice inválido, argumento ilegal.

## Custom Checked Exception
- Use quando outros desenvolvedores precisam tratar aquela condição de erro.
Ex: `class ClienteInvalidoException extends Exception {}`

## Custom unchecked exception
- Use quando a falha indica um erro de lógica que não deve ser forçado o tratamento.
Ex: `class ConfiguracaoInvalidaException extends RuntimeException {}`

# Dica:
- Checked exceptions para problemas previstos e recuperáveis
- Unchecked para erros de programação, validação ou regras de negócio.
