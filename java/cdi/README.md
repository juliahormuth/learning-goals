# O que é CDI?
- É a especificação do Java EE/Jakarta EE para injeção de dependências, gerenciamento de ciclo de vida, eventos e interceptadores.

## @Inject
- Injecao de dependencia, equivalente ao @Autowired do Spring.

```
@ApplicationScoped
public class MyService {
}

public class MyController {

    @Inject
    MyService service;
}
```
## Scopes - Ciclo de vida dos beans

### @ApplicationScoped
- Escopo de singleton por aplicacao (@Singleton do Spring)
- É criado quando o app inicializa e destruído quando o app para.

```
@ApplicationScoped
public class GlobalService {
}
```

### @RequestScoped
- Um bean POR REQUISICAO HTTP.
```
@RequestScoped
public class RequestContextData {
}
```
### @Singleton (CDI)
- Similar ao @ApplicationScoped, mas com algumas diferenças técnicas.
- @Singleton (CDI) → Bean é criado somente uma vez e possui lock global quando métodos são @Lock.
- @ApplicationScoped → Uso mais comum, não tem locking.

### @Dependent
- SEM ESCOPO
- Cada vez quem alguém o injeta, é criado um novo objeto.
- Equivalente ao @Scope("prototype") do Spring.
- Seguem o ciclo de vida do bean que os injeta.

```
@Dependent
public class TemporaryObject {
}
```
### @Produces
- É como um @Bean do Spring.
- Usado quando o objeto não pode ser criado pelo CDI automaticamente.
- Usado quando você precisa de lógica para instanciá-lo.
- Precisa devolver interfaces, tipos complexos, valores primitivos, recursos, conexões.

```
public class Producers {

    @Produces
    public Random produceRandom() {
        return new Random();
    }
}
```
- Assim alguém pode injetar:

```
@Inject
Random random;
```

### Produces com Qualifiers
- Para diferenciar objetos do mesmo tipo.

### Events (@Observes)
- Equivalente ao ApplicationEvent do Spring, mas muito mais simples

```
@Inject
Event<UserCreatedEvent> event;

public void createUser(User user) {
    // lógica...
    event.fire(new UserCreatedEvent(user));
}
```
Consumir evento:

```
public void onUserCreated(@Observes UserCreatedEvent evt) {
    System.out.println("Usuário criado: " + evt.getUser());
}
```

### @Transactional

### @AroundInvoke