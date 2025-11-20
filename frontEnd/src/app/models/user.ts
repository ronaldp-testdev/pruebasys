import { Generic } from "./generic";
import { Persona } from "./persona";

export class User implements Generic{
    id: number;
    email!: string;
    username!: string;
    password!: string;
    sessionActive: boolean;
    status!: string;
    persona: Persona;
}
