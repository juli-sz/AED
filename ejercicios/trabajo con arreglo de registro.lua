---
    para_arreglo =registro  
        codigo_amigo
        nombre
        apellido
        cantidad_d
        cantidad_v
        cantidad_c
        total
    fin registro
    totald,totalv,totalc:


para i=1 hasta 10
    segun reg_album[i].tipo hacer
        ="D":
            arr_album[i].cantidad_d:=arr_album[i].cantidad_d+
            arr_album[i].cantidad_c:=arr_album[i].cantidad_c+1
        = "C":
            arr_album[reg_album.cod_usuario][2]:=arr_album[reg_album.cod_usuario][2]+reg_album.cantidad
            arr_album[reg_album.cod_usuario][4]:=arr_album[reg_album.cod_usuario][4]+reg_album.cantidad
            arr_album[11][2]:=arr_album[11][2]+reg_album.cantidad
            arr_album[11][4]:=arr_album[11][4]+reg_album.cantidad
        = "V": entonces
            arr_album[reg_album.cod_usuario][3]:=arr_album[reg_album.cod_usuario][3]+reg_album.cantidad
            arr_album[reg_album.cod_usuario][4]:=arr_album[reg_album.cod_usuario][4]+reg_album.cantidad
            arr_alb[1]:=arr_album[11][3]+reg_album.cantidad
            arr_album[11][4]:=arr_album[11][4]+reg_album.cantidad
    fin segun
fin para
        
            




