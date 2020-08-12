import { Tim } from './tim';
import { Nacionalnost } from "./nacionalnost";

export class Igrac {
  id: number;
  ime: string;
  prezime: string;
  brojRegistracije: string;
  datumRodjenja: Date;
  nacionalnost: Nacionalnost;
  tim: Tim;
}
