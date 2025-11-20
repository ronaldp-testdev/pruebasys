import { Generic } from "./generic";

export class Role implements Generic{
    id: number;
    name!: string;
    activated: boolean;

}
