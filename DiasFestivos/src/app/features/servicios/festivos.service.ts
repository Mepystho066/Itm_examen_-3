import { Injectable } from '@angular/core';
import { environment } from '../../../environments/environment.prod';
import { Observable } from 'rxjs';
import { Festivo } from '../../core/entidades/Festivo';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class FestivosService {
  private url:string;
  constructor( private http:HttpClient) { 
    this.url = `${environment.urlBase}festivo/`;
  }
  // aqui toca definir el tipo de va a obtener 
   public listar(): Observable<Festivo[]>{
     // Resive un objeto por medio de la url 
    return this.http.get<Festivo[]>(`${this.url}listar`);
   
   }

   public logica(año:number): Observable<Festivo[]>{
    // Resive un objeto por medio de la url 
    return this.http.get<Festivo[]>(`${this.url}logica/${año}`);
  
  }

  public agregar(festivo:Festivo): Observable<Festivo>{
      return this.http.post<Festivo>(`${this.url}agregar`,festivo);
  }

  public modificar(festivo:Festivo): Observable<Festivo>{
    return this.http.put<Festivo>(`${this.url}modificar`,festivo);
  }

  public eliminar(id:number): Observable<Festivo>{
    return this.http.delete<Festivo>(`${this.url}eliminar/${id}`);
  }
  public buscar(nombre:String): Observable<Festivo[]>{
    return this.http.get<Festivo[]>(`${this.url}buscar/${nombre}`);
  }


}
