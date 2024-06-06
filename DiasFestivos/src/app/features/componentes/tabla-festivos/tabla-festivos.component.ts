import { Component } from '@angular/core';
import { ReferenciasMaterialModule } from '../../../shared/modulos/referencias-material.module';
import { FormsModule } from '@angular/forms';
import { ColumnMode, NgxDatatableModule, SelectionType } from '@swimlane/ngx-datatable';
import {Festivo} from '../../../core/entidades/Festivo'
import { formatDate } from '@angular/common';
import { FestivosService } from '../../servicios/festivos.service';
import { Tipo } from '../../../core/entidades/Tipo';
import { MatDialog } from '@angular/material/dialog';
import { FestivoEditarComponent } from '../festivo-editar/festivo-editar.component';
import { DecidirComponent } from '../../../shared/componentes/decidir/decidir.component';
@Component({
  selector: 'app-tabla-festivos',
  standalone: true,
  imports: [
    ReferenciasMaterialModule,
    FormsModule, // para entrada de datos 
    NgxDatatableModule,
  ],
  templateUrl: './tabla-festivos.component.html',
  styleUrl: './tabla-festivos.component.css'
})
export class TablaFestivosComponent {
  /* problemas para que no se muestre la fecha 
  public fechasPicker = new Date ; 
  public fechasPicker:   Date | undefined ; 
  */
  public fechasPicker: string = "";
  public festivos: Festivo [] =[];
  //public tiposFestivo: Tipo [] = [];
  public nombreFestivo:String ="";
  
  public modoColumnas =  ColumnMode;
  public seleccionarFestivo = SelectionType;
  public festivoEscogido: Festivo | undefined; 

  public columnas :any[] = [
    {name:"Festivo", prop:"nombre"},
    {name:"Dia", prop:"dia" },
    {name:"Mes", prop:"mes"}
  ]
 // esta es la columnade logica  
  public columnasLogica:any[]=[
    {name:"Festivo", prop:"nombre"},
    {name:"Fecha", prop:"fecha" },
  ]

  // servicio para cuadros de dialogo : MatDialog ,  para poder cargar el cuadro de  dialog desde buscar
  constructor(private servicio: FestivosService , private servicioDialogo: MatDialog ){
    this.listar()

  }

  escoger( event:any){
    if (event.type=="click"){
      this.festivoEscogido=event.row;
    }
  }

  public listar(){ // al ser un observable se tiene que sucribir 
     this.servicio.listar().subscribe({
      next: response =>{
        this.festivos= response;
      },
      error: error =>{
        window.alert(error.mensage)
      }

     });
  }

public logica(){
  // logica necesita un año 
  const fechas = new Date(this.fechasPicker);
  var años = fechas?.getFullYear(); 
 // console.log(años)
  this.servicio.logica(años).subscribe({
  next: response =>{
    this.festivos= response;
  },
  error: error =>{
    window.alert(error.mensage)
  }
  });

}


  public agregar(){
    // Aqui se muestar el cuadro de dialogo 
    const dialogo  = this.servicioDialogo.open(FestivoEditarComponent,{
      //parametros
      width: "400px",
      height : "300px",
      disableClose: true,
      // para enviar datos con esa estructura 
      data : {
        encabezado : "Agregar festivo",
        festivo :{
          id:0,
          nombre:"",
          dia:0,
          mes:0,
        }
      }
    });
  
    dialogo.afterClosed().subscribe({
      next:datos =>{
        if (datos){
          this.servicio.agregar(datos.festivo).subscribe({
            next: next=>{
              this.servicio.buscar(datos.festivo.nombre).subscribe({
                next: response=>{
                  this.festivos = response;
                  window.alert("Festivo agregado")
                },
                error: error =>{
                  console.log("Seleccionar")
                }
    
              });

            },
            error: error =>{
              console.log(error.mensage)
            }

          });

        }

      }
          
    });

  }

  public obtener(){
    
  }

  modificar (){
     if (this.festivoEscogido){
      
      this.servicioDialogo.open(FestivoEditarComponent,{
        //parametros
        width: "400px",
        height : "300px",
        disableClose: true,
        // para enviar datos con esa estructura 
        data : {
          encabezado : `Modificando festivo ${this.festivoEscogido.nombre}`,
          festivo :this.festivoEscogido

        }
      });
      
     }
     
     else {
      window.alert("Seleccionar un dia festivo")
     }
  }

  verificarEliminar(){

    if (this.festivoEscogido){
      
      this.servicioDialogo.open(DecidirComponent,{
        //parametros
        width: "300px",
        height : "200px",
        disableClose: true,
        // para enviar datos con esa estructura 
        data : {
          encabezado : `Seguro de eliminar ${this.festivoEscogido.nombre} ?`,
          id:this.festivoEscogido.id

        }
      });
      
     }
     
     else {
      window.alert("Seleccionar un dia festivo")
     }

  }


  buscarNombre(){
    /// buscar se va acambiar por verificar 

    if( this.fechasPicker != null){
      this.servicio.buscar(this.nombreFestivo).subscribe({
        next: response=>{
          this.festivos = response;
        },
        error: error =>{
          console.log("Seleccionar")
        }
      });
    } 

    else{
      this.listar()
    }

  }
  
  public verificar(){
    const fechas = new Date(this.fechasPicker);
    const años = fechas?.getFullYear(); 
    const listaFestivos = this.logica();  


    
    const dia= fechas?.getDate() ;
    const mes= fechas?.getMonth() +1;
    const año= fechas?.getFullYear() ;
    //console.log(listaFestivos)
    //console.log(`Dia : ${dia} Mes: ${mes}  Año: ${año}`);
    //console.log(`Mostrando logica ${this.logica()}`)
    //window.alert(`Dia festivo ${this.fechasPicker}}`)

  }




}
