Accion ej_parcial1
    ambiente
        fecha=registro
            dia
            mes
            año
        fin reg
        intercambios = registro
            clave
            cod_amigo
            fecha_solicitud: fecha
        fin registro
        album = registro
            clave: N(5)
            cantidad: N(2)
            permitir_duplicado: ("si","no")
        fin registro
        cont: entero
        reg_int: intercambios
        reg_album,reg_nuevaFigurita: album
        arch_int: archivo de intercambios ordenado por clave, cod_amigo
        arch_album: archivo de album ordenado por clave
        
        procedimiento Leer_album(){
            leer(arch_album,reg_album)
            si FDA(arch_album) entonces
                reg_album.clave:=HV
            fin si
        }
        procedimiento Leer_int(){
            leer(arch_int,reg_int)
            si FDA(arch_int) entonces
                reg_int.clave:=HV
            fin si
        }

    proceso
           cont:=0
           Abrir E/(arch_int)
            Abrir E/S(arch_album)
            Leer_album()
            Leer_int()

            Mientras reg_album.clave<>"HV" o reg_int<>"HV" hacer
                Si reg_album.clave< reg_int.clave entonces
                    //clave de intercambios mayor
                    //avanzamos album
                    Leer_album()
                SINO
                    Si reg_album.clave = reg_int.clave entonces
                    //claves iguales
                    si reg_album.permitir_duplicado="si" entonces
                        reg_album.cantidad:=reg_album.cantidad+1
                        Regrabar(arch_album,reg_album)
                        cont:=cont+1
                    fin si                    
                    Leer_int()
                    si no
                        //clave de album mayor
                        //alta
                        si diff_fecha(7,reg_int.fecha) entonces
                            reg_nuevaFigurita.clave:=reg_int.clave
                            reg_nuevaFigurita.cantidad:=1
                            reg_nuevaFigurita.permitir_duplicado:="no"
                            Grabar(arch_album,reg_nuevaFigurita)
                        fin si
                        Leer_int()
                    fin si
                fin si
            fin Mientras

            Esc("la cantidad de figuritas duplicadas que se admitieron fue: ", cont);
            CERRAR(arch_album)
            CERRAR(arch_int)
        fin 





                













        
        
         
        
