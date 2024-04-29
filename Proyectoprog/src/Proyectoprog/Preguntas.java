package Proyectoprog;

public abstract class Preguntas {
String pregunta;
String respuesta;
public Preguntas(String enunciado) {
	this.pregunta=enunciado;
}
public abstract void mostrarRespuesta();
}
