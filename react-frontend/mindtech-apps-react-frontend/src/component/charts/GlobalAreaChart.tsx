import {Area, AreaChart, CartesianGrid, ResponsiveContainer, Tooltip, XAxis, YAxis} from "recharts";
import React, {useEffect, useState} from "react";
import PropTypes from 'prop-types';

export default function GlobalAreaChart(props: any) {

    const [data, setData] = useState(props.data);

    useEffect(() => {
        setData(props.data);
    }, [props.data])


    return (
        <div>
            {
                props.isVisible ?
                    <ResponsiveContainer minHeight={300} minWidth={300}>
                        <AreaChart width={730} height={250} data={data}
                                   margin={{top: 10, right: 30, left: 0, bottom: 0}}>
                            <defs>
                                {
                                    props.areas.map((area: any, index: number) => {
                                        return (
                                            <linearGradient key={'color-' + index} id={'color-' + index} x1="0" y1="0" x2="0" y2="1">
                                                <stop offset="5%" stopColor={area.stroke} stopOpacity={0.8}/>
                                                <stop offset="95%" stopColor={area.fill} stopOpacity={0}/>
                                            </linearGradient>
                                        )
                                    })
                                }
                            </defs>
                            <XAxis dataKey="lastUpdatedAtApify"/>
                            <YAxis/>
                            <CartesianGrid strokeDasharray="3 3"/>
                            <Tooltip/>
                            {
                                props.areas.map((area: any, index: number) => {
                                    return <Area key={props.id + '-' + index} type={area.type} dataKey={area.dataKey}
                                                 stroke={area.fill}
                                                 fillOpacity={1} fill={'url(#color-' + index + ')'}/>
                                })
                            }
                        </AreaChart>
                    </ResponsiveContainer>
                    : ''
            }
        </div>
    )
}

GlobalAreaChart.propTypes = {
    areas: PropTypes.array.isRequired,
    isVisible: PropTypes.bool.isRequired,
    data: PropTypes.array.isRequired,
    id: PropTypes.string.isRequired
}