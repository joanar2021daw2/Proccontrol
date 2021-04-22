import {Referencia} from './referencia';
import {Pas} from './pas';


export class Proces {
    idProces : any;
    nom : string | undefined;
    referencia : Referencia | undefined;
    numPassos : number = 0 ;
    passos: Pas[] = [];

   /* constructor(idProces:number, nom: string, referencia: Referencia, numPassos: number, passos: Pas[]){
        this.idProces = idProces;
        this.nom  = nom;
        this.referencia = referencia;
        this.numPassos = numPassos;
        this.passos = passos;
    }*/

    

}

