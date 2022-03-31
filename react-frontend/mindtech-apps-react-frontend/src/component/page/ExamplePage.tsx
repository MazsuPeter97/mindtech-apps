import React, {useState} from "react";
import {useFormik} from 'formik';
import {Grid} from "@mui/material";
import {exampleService} from "../../services/ExampleService";
import GlobalDateSelect from "../globalElements/GlobalDateSelect";
import GlobalButton from "../globalElements/GlobalButton";
import GlobalSelect from "../globalElements/GlobalSelect";
import GlobalLineChart from "../charts/GlobalLineChart";
import GlobalBarChart from "../charts/GlobalBarChart";
import GlobalAreaChart from "../charts/GlobalAreaChart";
import {DataInterval} from "../../classes/DataInterval";

const items = [
    {key: 'LINE', value: 'Vonal'},
    {key: 'BAR', value: 'Oszlop'},
    {key: 'AREA', value: 'Terület'}
]

const lines = [
    {type: 'monotone', dataKey: 'infected', fill: '#707070'},
    {type: 'monotone', dataKey: 'activeInfected', fill: '#fa0202'},
    {type: 'monotone', dataKey: 'quarantined', fill: '#04b816'}
]

const bars = [
    {dataKey: 'infected', fill: '#707070'},
    {dataKey: 'activeInfected', fill: '#fa0202'},
    {dataKey: 'quarantined', fill: '#04b816'}
]

const areas = [
    {dataKey: 'infected', fill: '#000a8f', stroke: '#8888db', type: 'monotone'},
    {dataKey: 'activeInfected', fill: '#fa0202', stroke: '#dd6767', type: 'monotone'},
    {dataKey: 'quarantined', fill: '#00830f', stroke: '#6aff72', type: 'monotone'}
]


export default function ExamplePage(props: any) {

    const [data, setData] = useState([]);

    const formik = useFormik({
        initialValues: new DataInterval(new Date(), new Date(), ''),
        onSubmit: (values => {
            exampleService().filterData(values).then((response) => {
                setData(response.covidDTO);
            })
        })
    })

    return (
        <div style={{margin: '20px'}}>
            <form onSubmit={formik.handleSubmit}>
                <Grid container spacing={2} style={{margin: '0px auto'}}>
                    <Grid item xs={12} sm={3} style={{margin: '0px auto'}}>
                        <GlobalDateSelect label="Kezdő nap" onChange={(e) => formik.setFieldValue('startDate', e)}
                                          value={formik.values.startDate}/>
                    </Grid>

                    <Grid item xs={12} sm={3} style={{margin: '0px auto'}}>
                        <GlobalDateSelect label="Záró nap" onChange={(e) => formik.setFieldValue('lastDate', e)}
                                          value={formik.values.lastDate}/>
                    </Grid>

                    <Grid item xs={8} sm={3} style={{margin: '0px auto'}}>
                        <GlobalSelect id="diagramType" label="Diagram típusa" items={items}
                                      value={formik.values.diagramType} onChange={formik.handleChange}/>
                    </Grid>

                    <Grid item xs={12} sm={2} style={{margin: '0px auto'}}>
                        <GlobalButton type="submit" label="Keresés"/>
                    </Grid>

                </Grid>
            </form>

            <div style={{margin: '40px auto'}}>
                <Grid item xs={12} sm={8}>
                    <GlobalLineChart id={'covid-line-chart'} lines={lines} data={data}
                                     isVisible={formik.values.diagramType === 'LINE'}/>

                    <GlobalBarChart id={'covid-bar-chart'} bars={bars} data={data}
                                    isVisible={formik.values.diagramType === 'BAR'}/>

                    <GlobalAreaChart id={'covid-area-chart'} areas={areas} data={data}
                                     isVisible={formik.values.diagramType === 'AREA'}/>
                </Grid>
            </div>

        </div>
    )
}
