import {ExampleServiceStub} from "./stub/ExampleServiceStub";

export const exampleService = () => {
    return new ExampleServiceStub();
}