import {Button} from "@mui/material";
import React from "react";
import Proptypes from 'prop-types';

export default function GlobalButton(props: any) {

    return (
        <div>
            <Button variant="contained" type={props.type} onChange={props.onChange}>{props.label}</Button>
        </div>
    )
}

GlobalButton.propTypes = {
    type: Proptypes.string,
    onChange: Proptypes.func,
    label: Proptypes.string.isRequired
}
