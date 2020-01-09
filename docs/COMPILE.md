# OpenALPR

<sub>- [Compilando](#compilando)<br>
<sub>- [Executando no Python](#executando)<br>

## Compilando

Compilando o [Open ALPR](https://www.openalpr.com/) para reconhecer placar BR.

1. Compilar segundo o [_The Easyest Way_](https://github.com/openalpr/openalpr/wiki/Compilation-instructions-(Ubuntu-Linux)#the-easiest-way);

2. Copiar o diretório [`runtime_data/`]https://github.com/openalpr/openalpr/tree/master/runtime_data para o `/usr/share/openalpr/runtime_data/`

3. Seja feliz.

## Executando

Para executar o OpenALPR, basta chamar
`alpr -c br <img>`
onde:
> `-c br` indica o país da placa a ser analisada
> `<img>` caminho para a imagem

## Executando no Python

```
# chamando OpenALPR no Python
import subprocess
subprocess.run(["alpr", "-c", "br", "/home/mauricio/002.jpg"])
```
<!--stackedit_data:
eyJoaXN0b3J5IjpbLTUyODYxNTY0NiwxMTczNTI0MTMwLDExNz
M1MjQxMzAsLTIzMzE1MzM5Ml19
-->