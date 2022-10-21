# Parcial AREP 2
# Diego Leon
## 2022-2

## Descripción

Para empezar probamos que funcione correctamente en nuestro computador local, para eso hacemos uso de localhost:5000 para nuestra respuesta en JSON de la secuencia de Collatz generada a partir de ese numero.

![](img/Capture1.PNG)

Como el cliente no computa la secuencia directamente sino que la delega a un servicio REST que en este caso corre en nuestro servidor local, podemos probarlo con localhost:5001 y ver que el resultado es la URL del servicio REST que se encarga de generar la secuencia y el JSON con la secuencia.

![](img/Capture3.PNG)

![](img/Capture2.PNG)