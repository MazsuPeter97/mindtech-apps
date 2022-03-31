export class DataInterval {
    startDate: Date;
    lastDate: Date;
    diagramType: string;

    constructor(startDate: Date, lastDate: Date, diagramType: string) {
        this.startDate = startDate;
        this.lastDate = lastDate;
        this.diagramType = diagramType;
    }
}