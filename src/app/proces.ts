import {Referencia} from './referencia';
import {Pas} from './pas';


export class Proces {
    idProces : number | undefined;
    nom : string | undefined;
    referencia : Referencia | undefined;
    numPassos : number | undefined;
    passos: Pas[] | undefined;

}
