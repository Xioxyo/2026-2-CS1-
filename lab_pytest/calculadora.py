def sumar(a,b):
    return a + b

def dividir(a,b):
    if b==0:
     raise ValueError("No se puede dividir por cero")
    return a / b

def es_mayor_de_edad(edad):
    if edad<0:
        raise ValueError("La edad no puede ser negativa")
    return edad >= 18