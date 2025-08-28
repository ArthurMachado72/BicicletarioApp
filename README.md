Sistema Bicicletário App

Sistema desktop completo para gerenciamento de aluguel de bicicletas desenvolvido em Java com arquitetura moderna seguindo princípios SOLID.

Sobre o Projeto

Este projeto representa a refatoração completa de um sistema legado de aluguel de bicicletas, transformando uma aplicação com alto acoplamento em uma arquitetura bem estruturada seguindo melhores práticas de desenvolvimento.

Histórico de Refatoração

  Sistema Antigo:
- Acoplamento excessivo entre interface e regras de negócio
- Violação de princípios SOLID
- Code smells diversos
- Gerenciamento inadequado de recursos JPA
- Estrutura monolítica sem separação de concerns

  Sistema Atual:
- Arquitetura em camadas bem definidas
- Aplicação completa dos princípios SOLID
- Separação clara entre interface e regras de negócio
- Padrões de projeto implementados
- Código limpo e maintainable

  Arquitetura do Sistema

  br.com.bicicletarioapp/
├── 📁 application/ → Classe principal BicicletarioApplication
├── 📁 config/ → Configurações de banco (DatabaseConfig)
├── 📁 controller/ → Controladores (Aluguel, Bicicleta, Cliente)
├── 📁 dto/ → Data Transfer Objects
├── 📁 exception/ → Exceções personalizadas
├── 📁 model/ → Entidades JPA
├── 📁 repository/ → Camada de acesso a dados
├── 📁 service/ → Lógica de negócio (Interface + Implementação)
├── 📁 util/ → Utilitários (JPAUtil, DateUtils)
└── 📁 view/ → Interface gráfica (JFrames)


 Funcionalidades

   Implementadas
- Autenticação de Usuários - Sistema de login seguro
- Cadastro de Bicicletas - Gestão completa do inventário
- Cadastro de Clientes - Administração de clientes
- Controle de Aluguéis - Registro e gestão de aluguéis
- Cálculos Automáticos - Cálculo de valores e tempos de aluguel

  Próximas Funcionalidades
- Relatórios e estatísticas
- Sistema de pagamentos integrado
- Controle de manutenção de bicicletas
- Módulo de reservas online

  Tecnologias Utilizadas

- Java 17 - Linguagem de programação
- Maven - Gerenciamento de dependências
- JPA/Hibernate - Persistência de dados
- MySQL - Banco de dados
- Swing - Interface gráfica
- Git/GitHub - Controle de versão

  Princípios SOLID Aplicados

  Single Responsibility Principle
- Cada classe tem uma única responsabilidade
- Services → Lógica de negócio
- Repositories → Acesso a dados
- Controllers → Coordenação
- Views → Interface gráfica

  Open/Closed Principle
- Interfaces permitem extensão sem modificação
- IAluguelService, IBicicletaService, IClienteService

  Liskov Substitution Principle
- Implementações seguem contratos de interfaces
- Substituibilidade garantida

  Interface Segregation Principle
- Interfaces específicas e focadas
- Sem interfaces "gordas"

  Dependency Inversion Principle
- Dependência de abstrações, não implementações
- Injeção de dependências via construtores

  Funcionalidades

  Implementadas
 - Autenticação de Usuários - Sistema de login seguro
 - Cadastro de Bicicletas - Gestão completa do inventário
 - Cadastro de Clientes** - Administração de clientes
 - Controle de Aluguéis - Registro e gestão de aluguéis
 - Cálculos Automáticos - Cálculo de valores e tempos de aluguel

  Próximas Funcionalidades
- Relatórios e estatísticas
- Sistema de pagamentos integrado
- Controle de manutenção de bicicletas
- Módulo de reservas online

  Tecnologias Utilizadas

- Java 17 - Linguagem de programação
- Maven - Gerenciamento de dependências
- JPA/Hibernate - Persistência de dados
- MySQL - Banco de dados
- Swing - Interface gráfica
- Git/GitHub - Controle de versão

  Padrões de Projeto Implementados

Repository Pattern
java
public interface IUsuarioRepository {
    Usuario findByNome(String nome);
    Usuario save(Usuario usuario);
    // ...
}

Status do Projeto
Concluído:
Refatoração completa da arquitetura

Implementação dos princípios SOLID

Separação de concerns

Padrões de projeto

Sistema de autenticação

CRUD completo de todas entidades

Desenvolvimento:
Sistema de relatórios

Módulo de reservas

Integração com pagamento

Dashboard administrativo
