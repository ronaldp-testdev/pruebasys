import { Generic } from "./generic";
import { Role } from "./role";

export class RolOpciones implements Generic{
    id: number;
    nombreOpcion!: string;
    roles: Role[] = [];
    activated: boolean;

}
