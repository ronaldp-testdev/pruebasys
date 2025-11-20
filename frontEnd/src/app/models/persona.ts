import { Generic } from "./generic";

export class Persona implements Generic{
    id: number;
    nombres!: string;
    apellidos!: string;
    identificacion!: string;
    fechaNacimiento!: string;
    activated: boolean;
}
