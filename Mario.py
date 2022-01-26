# Mario Querol

def menu():
    print("")
    print("1) Beneficio a partir de cantidad")
    print("2) Punto de equilibrio")
    print("3) Cantidad a partir de beneficio")
    print("4) Salir")


opcion = 0
while opcion != 4:
    menu()
    opcion = int(input("Elegir opción: "))
    print("")

    # Si la opcion es la de salir no recibiremos nada
    if opcion == 4:
        print("Hasta pronto")
        exit()

    if opcion == 3:  # Beneficio solo para opcion 3
        beneficio = float(input("Beneficio: "))
    if opcion == 1:  # Cantidad solo para opcion 1
        cantidad = float(input("Cantidad: "))
    costesFijos = float(input("Costes fijos: "))
    precioVenta = float(input("Precio venta: "))
    costesVariables = float(input("Costes variables unitarios: "))

    if opcion == 1:
        print("---- Beneficio a partir de cantidad ----")
        resultado = precioVenta * cantidad - costesFijos - costesVariables
        print("El beneficio generado de vender ", cantidad, "cantidades es de ", round(resultado, 2))
    elif opcion == 2:
        print("---- Punto de equilibrio ----")
        resultado = costesFijos / (precioVenta - costesVariables)
        print("El punto de equilibrio es: ", int(resultado), " unidades")
    elif opcion == 3:
        print("Opcion3")
        resultado = (costesFijos + beneficio) / (precioVenta - costesVariables)
        print("Para obtener un beneficio de ", beneficio, " es necesario vender una cantidad de ", round(resultado, 2))
    else:
        print("Opción no válida")
    input("Para continuar pulse enter")