import { Generic } from "./generic";
import { User } from "./user";

export class Session implements Generic{
    id: number;
    fechaIngreso!: string;
    fechaCierre!: string;
    usuario: User;
    activated: boolean;
}
