import {BaseService} from "./BaseService";
import {ExampleControllerImplApi} from "../generated";
import {CovidResponse} from "../generated/models";
import {DataInterval} from "../../classes/DataInterval";

export class ExampleServiceStub extends BaseService {

    protected examplControllerImplApi: ExampleControllerImplApi;

    constructor() {
        super();
        this.examplControllerImplApi = new ExampleControllerImplApi(this.configuration);
    }

    private getDataFilterAPi(param: DataInterval) {
        return this.examplControllerImplApi.filterByDateUsingGET(param?.startDate.toISOString(), param?.lastDate.toISOString());
    }

    async filterData(param: DataInterval): Promise<CovidResponse> {
        console.log(param.startDate.toISOString())

        let response = await this.getDataFilterAPi(param);

        if (response.data) {
            return response.data;
        }

        return {};
    }

}