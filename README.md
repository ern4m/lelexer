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

### 5. Atualizando o Parser para suportar number
Nesta etapa se alterou o '_matching_' realizado na classe Parser, que previamente era através de comparação de _char_, que agora passa a ser realizado por comparações de TokenType. Além disso, fora realizada o tratamento no Scanner para evitar erros durante a leitura de _whitespaces_ durante a formação dos tokens.

### 6. Atualizando o Scanner e Parser para suportar variáveis
Nesta etapa foram realizadas alterações em todas as partes existentes, desde a adição de novos tipos de tokens para abranger LET, EQ e SEMICOLON, até a criação de um mecanismo utilizando HashMap para guardar os identificadores 'especiais' para podermos fazer uma diferenciação destes através da comparação do tipo dentro da função _identifier()_. Além disso, foram introduzidas funções auxiliares para verificarmos se o cursor está apontando para um valor alfaNumérico (necessário para obtermos identificadores). Por fim, dentro da classe Parser foi realizada a reorganização da disposição da gramática, uma vez que agora temos novos termos, criando a função term() para tratar NUMBER e IDENT, junto à definição do conceito de atribuição através da fuunção letStatement().

### 7. Incluindo comando de impressão
Através da implementação de um novo possível tipo em nossos tokens e de uma nova keyword no HashMap temos a possibilidade de um statement _**print**_ do 'tipo' _printStament -> 'print' expression ';'_. Desse modo, assim como a implementação do _**let**_ temos que realizar alterações no Parser, uma vez que o tratamento de novos identifiers em nosso Scanner já está estabelecido.

Desse modo, realizamos a implementação da função _printStatement()_ como definida acima e, além disso, agora podemos agrupar nossos programas escritos como conjuntos de statements, limitando nosso Parser a aceitar somente statements que sejam válidos de acordo com as definições de statements implementadas(printStatement e letStatement).