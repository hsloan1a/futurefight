import React from 'react'

import axios from 'axios'
import {Button} from "react-bootstrap";
import {Level} from "./model/Level";
import Form from "react-bootstrap/Form";
import {FaMinus, FaPlus} from 'react-icons/fa';

class LevelList extends React.Component {

    private submitData = () => {
        let level: Level = {
            "floor_type": "RELAY",
            "level": 1
        }
        axios.post('shadowland/level/', level).then(() => {

        })
    };

    render() {
        return (
            <div>
            <Form>
                <Form.Row>
                    <Button><FaPlus/></Button>
                </Form.Row>
                <Form.Row>
                    <Form.Control
                        type="text"
                        onChange={(event) => this.handleChange(event)}
                    />
                </Form.Row>
                <Form.Row>
                    <Button><FaMinus/></Button>
                </Form.Row>
            </Form>
            <Button onClick={this.submitData}>

            </Button>
            </div>
        )
    }

    private handleChange(event: React.ChangeEvent<HTMLInputElement | HTMLSelectElement | HTMLTextAreaElement>) {
        console.log(event.target.value);

    }
}

export default LevelList;