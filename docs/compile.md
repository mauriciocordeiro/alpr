# OpenALPR

<sub>[Compilando](#compilando)</sub><br>
<sub>[Executando](#executando)</sub><br>
<sub><sub>[Executando no Python](#executando-no-python)</sub></sub><br>
<sub><sub>[Executando no Java](#executando-no-java)</sub></sub><br>

## Compilando

Compilando o [Open ALPR](https://www.openalpr.com/) para reconhecer placar BR.

1. Compilar segundo o [_The Easyest Way_](https://github.com/openalpr/openalpr/wiki/Compilation-instructions-(Ubuntu-Linux)#the-easiest-way);

2. Copiar o diretório [`runtime_data/`](https://github.com/openalpr/openalpr/tree/master/runtime_data) para o `/usr/share/openalpr/runtime_data/`

3. Seja feliz.

## Executando

Para executar o OpenALPR, basta chamar
`alpr -c br <img>`
onde:
> `-c br` indica o país da placa a ser analisada

> `<img>` caminho para a imagem

### Executando no Python

```python
# chamando OpenALPR no Python
import subprocess
subprocess.run(["alpr", "-c", "br", "/home/mauricio/002.jpg"])
```

### Executando no Java

```java
// chamando o OpenALOP no Java
	public static String alpr() {
		try {
			
			ProcessBuilder builder = new ProcessBuilder("wsl", "alpr", "-j");
			builder.redirectErrorStream(true);
			final Process process = builder.start();

			watch(process);
			
			return "done";
		} catch(Exception e) {
			e.printStackTrace(System.out);
			return null;
		}
	}
	
	private static void watch(final Process process) {
	    new Thread() {
	        public void run() {
	            BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
	            String line = null; 
	            try {
	                while ((line = input.readLine()) != null) {
	                    System.out.println(line);
	                }
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }.start();
	}

```

<!--stackedit_data:
eyJoaXN0b3J5IjpbMTI0NjkyODYxNSwtMTE0MjgxOTMxNSwxMj
Q2OTI4NjE1XX0=
-->
