import React, {useState} from 'react'
import {Level} from "../model/Level";
import Accordion from "react-bootstrap/Accordion";
import Card from "react-bootstrap/Card";

import Button from "react-bootstrap/Button";
import Modal from "react-bootstrap/Modal";
import Form from 'react-bootstrap/Form';
import {ShadowlandLevelType} from "../../../constants/ShadowlandLevelType";

import "./LevelListDetail.css"

type levelListDetailProps = {
    levelList: Array<Level>,
    createLevel: (arg0: Level) => void,
    currentSelectedLevel: number
}

const LevelListDetail = (props: levelListDetailProps) => {

    const [show, setShow] = useState(false);

    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);

    const handleSubmit = (event: React.FormEvent<HTMLFormElement>)  => {
        event.preventDefault();
        let level: Level = {
            "floor_type": event.currentTarget.levelSelect.value,
            "level": props.currentSelectedLevel,
            "character_portrait": event.currentTarget.boss.value,
        };
        props.createLevel(level);
        handleClose()
    }

    const addModal = () => {
        return (
            <Modal show={show} onHide={handleClose}>
                <Modal.Header closeButton>
                    <Modal.Title>Add New Level</Modal.Title>
                </Modal.Header>
                <Modal.Body>
                    <Form onSubmit={handleSubmit}>
                        <Form.Control
                            type="input"
                            placeholder="Boss"
                            name="boss"
                            // onChange={(event) => handleChange(event)}
                        />
                        <Form.Label>Custom select</Form.Label>
                        <Form.Control name="levelSelect" as="select" custom>
                            {ShadowlandLevelType.map((levelType, index) => {
                                return <option key={index} value={levelType.backend}>{levelType.description}</option>
                            })}
                        </Form.Control>

                        <Button variant="secondary" onClick={handleClose}>Close</Button>
                        <Button variant="primary" type="submit">Submit form</Button>
                    </Form>
                </Modal.Body>
            </Modal>
        )
    };

    const displayAccordian = (levelList: Array<Level>) => {
        if (levelList.length <= 0)
            return null;
        return (
            <Accordion defaultActiveKey="0">
                <p>Type/Boss</p>
                {props.levelList.map((level, index) => {
                    return (
                        <Card key={level.id}>
                            <Accordion.Toggle as={Card.Header} eventKey={level.id ? level.id.toString() : index.toString()}>
                                {level.floor_type} {level.character_portrait}
                            </Accordion.Toggle>
                            <Accordion.Collapse eventKey={level.id ? level.id.toString() : index.toString()}>
                                <AccordionDetail></AccordionDetail>
                            </Accordion.Collapse>
                        </Card>
                    )
                })}

            </Accordion>
        )
    }


    return (
        <div>
            {displayAccordian(props.levelList)}
            <Button onClick={handleShow}>Add New Level</Button>
            {addModal()}
        </div>
    )
}

export default LevelListDetail

const AccordionDetail = () => {
    return (
        <div>
            <Button>Delete</Button>
            <p>hold</p>
        </div>
    )
}