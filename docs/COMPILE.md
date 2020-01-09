# OpenALPR

Compilando o [Open ALPR](https://www.openalpr.com/) para reconhecer placar BR.

1. Compilar segundo o [_The Easyest Way_](https://github.com/openalpr/openalpr/wiki/Compilation-instructions-(Ubuntu-Linux)#the-easiest-way);

2. Copiar o diretório [`runtime_data/`]https://github.com/openalpr/openalpr/tree/master/runtime_data para o `/usr/share/openalpr/runtime_data/`

3. Seja feliz.

================================================================================

# executando comando shell no python
>>> import subprocess
>>> subprocess.run(["alpr", "-c", "br", "/home/mauricio/002.jpg"])

================================================================================
<!--stackedit_data:
eyJoaXN0b3J5IjpbLTM4MTc3OTA2MSwtMjMzMTUzMzkyXX0=
-->