import React, {useEffect, useState} from "react";
import {FormControl, MenuItem, Select, InputLabel} from "@mui/material";
import PropTypes from 'prop-types';

export default function GlobalSelect(props: any) {

    const [items, setItems] = useState(props.items);

    useEffect(() => {
        setItems(props.items);
    }, [props.items])

    return (
        <div>

            <FormControl fullWidth>
                <InputLabel>{props.label}</InputLabel>
                <Select
                    key={props.id}
                    native
                    label={props.label}
                    name={props.id}
                    {...props}
                >
                    <option key='default' value='-'>-</option>

                    {
                        items.map((item: any, index: number) => {
                            return (
                                <option key={props.id + '_' + index} value={item.key}>{item.value}</option>
                            )
                        })
                    }
                </Select>
            </FormControl>

        </div>
    )
}

GlobalSelect.propTypes = {
    value: PropTypes.string.isRequired,
    id: PropTypes.string.isRequired,
    label: PropTypes.string.isRequired,
    onChange: PropTypes.func.isRequired,
    items: PropTypes.array.isRequired,
    other: PropTypes.object
}