import { Tipo } from "./Tipo";

export interface Festivo {
    
    id : number;
    nombre : string;
    dia: number;
    mes:number;
    diapascua: number;
    tipo: Tipo;
}

/*
 "id": 2,
    "nombre": "Santos Reyes",
    "dia": 6,
    "mes": 1,
    "diapascua": 0,
    "tipo": {
      "id": 2,
      "tipo": "Ley Puente Festivo"
    }
*/