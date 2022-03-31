import {Configuration} from "../generated";

export abstract class BaseService {
    configuration: Configuration;

    constructor() {
        this.configuration = createConfiguration();
    }
}

export function createConfiguration() {
    return new Configuration({basePath: 'http://localhost:8080'})
}