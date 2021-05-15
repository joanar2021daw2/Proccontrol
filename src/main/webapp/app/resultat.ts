//Classe del domini Resultat

import { Proces } from "./proces";
import { Usuari } from "./usuari";

export class Resultat {

    idResultat: any = null;
    usuari: Usuari = new Usuari();
    proces: Proces = new Proces();
    dataRegistre: any = null;
    comentariPassos: string[] = [];
    tempsPassos: number[] = [];
    tempsTotal: number = 0;
    
    /**
     * setProces
     */
    public setProces(proces: Proces) {
        this.proces = proces;        
    }

}
