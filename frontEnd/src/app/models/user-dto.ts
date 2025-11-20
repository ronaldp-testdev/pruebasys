import { Generic } from "./generic";
import { Persona } from "./persona";

export class UserDto implements Generic {

    id: number;
    email!: string;
    username!: string;
    sessionActive: boolean;
    status!: string;
    persona: Persona;

}
