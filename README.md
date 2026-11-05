# 🛰️ IMORTAL-1 – Sistema de Bordo

Sistema de simulação e análise de leituras de sensores desenvolvido em Java como atividade prática. Gera leituras aleatórias e oferece menu interativo para análise estatística completa.

---

## 📋 Sobre o projeto

O programa simula um **sistema de bordo** que coleta leituras de sensores (valores aleatórios entre 0 e 2000) e permite ao usuário analisar esses dados através de um menu interativo com diversas operações estatísticas.

---

## 🎯 Funcionalidades

| Opção | Descrição |
|-------|-----------|
| **1 – Média** | Calcula e exibe a média aritmética das leituras |
| **2 – Máx/Mín** | Mostra valor máximo e mínimo com suas respectivas posições (número da leitura) |
| **3 – Desvios** | Exibe o desvio de cada leitura em relação à média |
| **4 – Verificação de faixa** | Define limites mínimo/máximo aceitáveis e classifica cada leitura como **OK**, **ABAIXO DO LIMITE** ou **ACIMA DO LIMITE** |
| **5 – Relatório completo** | Gera relatório consolidado com todas as análises acima |
| **0 – Sair** | Retorna ao menu principal ou encerra o programa |

---

## 🔄 Fluxo do programa

```
┌─────────────────────────────────────┐
│  Quantas leituras? (3 a 100)        │
└──────────────┬──────────────────────┘
               ▼
┌─────────────────────────────────────┐
│  Gera N leituras aleatórias (0-2000)│
└──────────────┬──────────────────────┘
               ▼
┌─────────────────────────────────────┐
│  Menu interativo (loop até sair)    │
│  1-Média  2-Máx/Mín  3-Desvios      │
│  4-Faixa  5-Relatório  0-Sair       │
└──────────────┬──────────────────────┘
               ▼
┌─────────────────────────────────────┐
│  Nova simulação? (s/n)              │
└─────────────────────────────────────┘
```

---

## ✅ Validações implementadas

| Validação | Detalhes |
|-----------|----------|
| **Número de leituras** | Apenas inteiros entre **3 e 100** |
| **Opções do menu** | Apenas inteiros entre **0 e 5** |
| **Entradas numéricas** | Trata `NumberFormatException` (letras, vazio, símbolos) |
| **Separador decimal** | Aceita tanto `.` (ponto) quanto `,` (vírgula) |
| **Sim/Não** | Case-insensitive (`s`, `S`, `n`, `N`) |

---

## 🛠️ Tecnologias e conceitos utilizados

- **Java** (8+)
- `Scanner` – entrada de dados pelo terminal
- `Math.random()` – geração de valores aleatórios
- Arrays (`double[]`) – armazenamento das leituras
- **Estruturas de repetição** (`while`, `for`)
- **Estruturas condicionais** (`if`, `else if`, `else`, `switch`)
- **Tratamento de exceções** (`try-catch` para `NumberFormatException`)
- **Métodos estáticos** – modularização do código
- **Formatação de saída** – `printf` com `%.2f`
- Lógica de programação e algoritmos básicos

---

## 📌 Exemplo de funcionamento

**Entrada:**
```text
Quantas leituras serão realizadas? 5
Escolha uma opção: 5
Digite o mínimo aceitável: 500
Digite o máximo aceitável: 1500
```

**Saída:**
```text
=== IMORTAL-1 – SISTEMA DE BORDO ===
Quantas leituras serão realizadas? 5
Leitura 1: 1234,56
Leitura 2: 789,12
Leitura 3: 1567,89
Leitura 4: 234,56
Leitura 5: 987,65
--- MENU ---
1 - Média
2 - Máx/Mín
3 - Desvios
4 - Verificação de faixa
5 - Relatório
0 - Sair
Escolha uma opção: 5
Digite o mínimo aceitável: 500
Digite o máximo aceitável: 1500
============ RELATÓRIO COMPLETO ============
Quantidade de leituras: 5
Leituras:
Leitura 1: 1234,56
Leitura 2: 789,12
Leitura 3: 1567,89
Leitura 4: 234,56
Leitura 5: 987,65
Média: 962,76
Máximo: 1567,89 (Leitura 3)
Mínimo: 234,56 (Leitura 4)
Desvios em relação à média:
Leitura 1: 271,81
Leitura 2: -173,63
Leitura 3: 605,14
Leitura 4: -728,19
Leitura 5: 24,89
Verificação de faixa (500,00 a 1500,00):
Leitura 1: OK
Leitura 2: OK
Leitura 3: ACIMA DO LIMITE
Leitura 4: ABAIXO DO LIMITE
Leitura 5: OK
============================================
```

---

## 🧩 Estrutura do código

```
src/
└── ImortalNicolasEGiancarlo.java   # Classe principal (tudo em um arquivo)
```

### Métodos principais

| Método | Descrição |
|--------|-----------|
| `main()` | Loop principal, menu, controle de simulações |
| `lerInteiroValido()` | Leitura robusta de `int` com validação de range |
| `lerDoubleValido()` | Leitura robusta de `double` com suporte a vírgula |
| `calcularMedia()` | Média aritmética do array |
| `encontrarMaximo()` | Maior valor do array |
| `encontrarMinimo()` | Menor valor do array |
| `verificarFaixa()` | Classifica cada leitura (OK / ABAIXO / ACIMA) |
| `exibirRelatorioCompleto()` | Relatório consolidado com tudo |

---

## 🎓 Objetivo

Praticar conceitos fundamentais de programação em Java:

- Entrada e validação de dados do usuário
- Geração e manipulação de arrays
- Operações matemáticas e estatísticas básicas
- Estruturas de controle (repetição, decisão)
- Tratamento de exceções
- Modularização com métodos
- Formatação de saída no terminal
- Lógica de programação aplicada a problemas reais

---

## 👨‍💻 Autor

**Nícolas Maciel Lemos Batista**

Estudante do Técnico em Desenvolvimento de Sistemas — IFSul