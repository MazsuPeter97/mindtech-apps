import React, {useEffect, useState} from 'react';
import {Bar, ResponsiveContainer, BarChart, CartesianGrid, Legend, Tooltip, XAxis, YAxis} from "recharts";
import PropTypes from 'prop-types';


export default function GlobalBarChart(props: any) {

    const [data, setData] = useState(props.data);

    useEffect(() => {
        setData(props.data);
    }, [props.data])

    return (
        <div>
            {
                props.isVisible ?

                    <ResponsiveContainer minHeight={300} minWidth={300}>
                        <BarChart
                            key={props.id}
                            data={data}
                            margin={{
                                top: 5,
                                right: 30,
                                left: 20,
                                bottom: 5,
                            }}
                        >
                            <CartesianGrid strokeDasharray="3 3"/>
                            <XAxis dataKey="lastUpdatedAtApify"/>
                            <YAxis/>
                            <Tooltip/>
                            <Legend/>
                            {
                                props.bars.map((bar: any, index: number) => {
                                    return <Bar key={props.id + '-' + index} dataKey={bar.dataKey} fill={bar.fill}/>
                                })
                            }
                        </BarChart>
                    </ResponsiveContainer>
                    : ''
            }

        </div>
    )
}

GlobalBarChart.propTypes = {
    bars: PropTypes.array.isRequired,
    isVisible: PropTypes.bool.isRequired,
    data: PropTypes.array.isRequired,
    id: PropTypes.string.isRequired
}