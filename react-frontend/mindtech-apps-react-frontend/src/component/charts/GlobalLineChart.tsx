import {CartesianGrid, ResponsiveContainer, Line, LineChart, Tooltip, XAxis, YAxis, Legend} from "recharts";
import React, {useEffect, useState} from "react";
import PropTypes from 'prop-types';
import {format} from 'date-fns'

export default function GlobalLineChart(props: any) {

    const [data, setData] = useState(props.data);

    useEffect(() => {
        setData(props.data);
    }, [props.data])

    return (
        <div>
            {
                props.isVisible ?

                    <ResponsiveContainer minHeight={300} minWidth={300}>
                        <LineChart
                            key={props.id}
                            data={data}
                            margin={{top: 5, right: 20, left: 10, bottom: 5}}
                        >
                            <XAxis dataKey="lastUpdatedAtApify"/>
                            <YAxis/>
                            <Legend/>
                            <Tooltip/>
                            <CartesianGrid stroke="#f5f5f5"/>

                            {
                                props.lines.map((line: any, index: number) => {
                                    return <Line key={props.id + '_' + index} type={line.type} dataKey={line.dataKey}
                                                 stroke={line.fill}/>
                                })
                            }
                        </LineChart>
                    </ResponsiveContainer>
                    : ''
            }
        </div>
    )
}

GlobalLineChart.propTypes = {
    lines: PropTypes.array.isRequired,
    data: PropTypes.array.isRequired,
    isVisible: PropTypes.bool.isRequired,
    id: PropTypes.string.isRequired
}

