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

   public logica(): Observable<Festivo[]>{
    // Resive un objeto por medio de la url 
   return this.http.get<Festivo[]>(`${this.url}logica`);
  
  }


}
