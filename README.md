Sistema de Gestión de Biblioteca

Objectiu
Desenvolupa un sistema de gestió de biblioteca en Java que permeti el següent:
Registrar, cercar, fer prèstec i retorn de llibre.
Emmagatzemar les dades en un fitxer CSV.
Has de fer servir programació estructurada, modular, POO i gestió de fitxers.

Implementa les col.leccions, exepcions i validacions específiques.

Enunciat
Has de crear un sistema de gestió per a la biblioteca local seguint els requeriments generals, les funcionalitats obligatories i els requeriments técnics que t'ha fet arribar el seu director.

Requeriments Generals:
Els llibres han de tenir: ISB (format XXX-XXXXX-XXX, validat amb regex), títol, autor i estat (DISPONIBLE o EN PRESTEC).
Objectes: Llibre, Biblioteca, GestorArxius.
Fer servir un HashMap<String, Llibre> per enmagatzemar llibres en memoria (clau: ISBN).
Funcionalitats Obligatories:
Afegir llibre (validar ISBN únic i format).
Cercar per títol (case-insensitive, però emmagatzemar amb case-sensitive).
Fer prestec / retornar llibre (modificar el seu estat).
Guardar / carregar dades des de / cap a un fitxer anomenat biblioteca.csv.
Requeriments Técnics:
Fes servir static per el HashMap a Biblioteca.
Introdueix comentaris del tipus Javadoc (cerqueu com fer-ho) a totes les classes i mètodes públics.
