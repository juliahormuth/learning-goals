# O que é um Cluster?

- No Kubernetes, um Cluster é um conjunto de computadores (máquinas ou servidores) que trabalham juntos como se fossem um só computador gigante.

- Ele é formado por:

1. Master/Control Plane: É o "cérebro" que decide o que cada máquina vai fazer.
2. Workers(nós de trabalho): Sao as máquinas que realmente executam as aplicacoes (seus containers).

- O Kubernetes organiza tudo dentro desse cluster. Ele sabe onde rodar seus containers, como distribuir a carga, como reiniciar se cair, etc.

# O que é Kubernetes?

- Uma ferramente de orquestracao de containers.

- Permite a criacao de múltiplos containers em diferentes máquinas (nodes).

- Escalando projetos, formando um cluster.

- Gerencia servicos, garantindo que as aplicacoes sejam executadas sempre da mesma forma.
