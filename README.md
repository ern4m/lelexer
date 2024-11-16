## Lelexer
Projeto de introdução à compiladores a partir da implementação de um parser.

### 1. Um simples tradutor
Nesta etapa é implementado um simples parser/tradutor para traduzir um bytearray do modelo: "8+5-7+9" para instruções como: `push 8 push 5 add push 7 sub push 9 add`.

### 2. Analisador léxico
Nesta etapa é realizada a introdução às características e responsabilidades de um analisador léxico e como ocorre a interação deste com o analisador sintático. Além disso, são apresentadas possíveis abordagens de implementação de um analisador léxico como: scanners por tabela, scanners diretos e ad hoc (este faz uso de ferramentas dedicadas à geração de lexers através da definição das regras acerca dos tokens)