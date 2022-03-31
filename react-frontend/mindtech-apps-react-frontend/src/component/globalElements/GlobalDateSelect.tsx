import LocalizationProvider from "@mui/lab/LocalizationProvider";
import AdapterDateFns from "@mui/lab/AdapterDateFns";
import hu from "date-fns/locale/hu";
import {DateTimePicker} from "@mui/lab";
import TextField from "@mui/material/TextField";
import React from "react";
import PropTypes from 'prop-types';

export default function GlobalDateSelect(props: any) {

    return (
        <div>
            <LocalizationProvider dateAdapter={AdapterDateFns} locale={hu}>
                <DateTimePicker
                    label={props.label}
                    value={props.value}
                    onChange={props.onChange}
                    renderInput={(params) => <TextField {...params} />}
                />
            </LocalizationProvider>
        </div>
    )
}
GlobalDateSelect.propTypes = {
    label: PropTypes.string.isRequired,
    value: PropTypes.any.isRequired,
    onChange: PropTypes.func.isRequired
}
