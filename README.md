## Lelexer
Projeto de introdução à compiladores a partir da implementação de um parser.

### 1. Um simples tradutor
Nesta etapa é implementado um simples parser/tradutor para traduzir um bytearray do modelo: "8+5-7+9" para instruções como: `push 8 push 5 add push 7 sub push 9 add`.

### 2. Analisador léxico
Nesta etapa é realizada a introdução às características e responsabilidades de um analisador léxico e como ocorre a interação deste com o analisador sintático. Além disso, são apresentadas possíveis abordagens de implementação de um analisador léxico como: scanners por tabela, scanners diretos e ad hoc (este faz uso de ferramentas dedicadas à geração de lexers através da definição das regras acerca dos tokens)

### 3. Refatorando o tradutor: incluindo o analisador léxico 
Neste tópico é removida do Parser a responsabilidade de iterar sobre o bytearray e gerar tokens, introduzindo uma nova classe Scanner para realizar essa funcionalidade e retornar tokens a serem utilizados pelo parser.

### 4. Suportando o tipo de token number
Nesta etapa é tratado o caso de entradas numéricas de múltiplos dígitos tanto através da implementação via String, quanto a partir da implementação por Tokens, realizando a tipificação dos tokens de acordo com sua finalidade (operators e literals).

A classe Token faz uso de um enumerador para definir os tipos possíveis de um token, e de uma String para manter o valor que foi '_parseado_'.