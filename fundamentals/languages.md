# Linguagem Compilada
- Ex: C

```
Código fonte
    ↓
Compilador
    ↓
Machine code (binário)
```

# Linguagem interpretada
- Ex: Python

```
Código fonte
    ↓
Interpretador
    ↓
Bytecode // nao é linguagem de maquina. É um intermediário
    ↓
    VM
```

# Java
- Código `.java` é compilado pelo compilador `javac` em **bytecode** (`.class`).
- Bytecode é executado pela `JVM`
- `JVM` interpreta o Bytecode ou usa "Just in time compiler" para compilar partes do código em código de máquina nativo em tempo de execucao.