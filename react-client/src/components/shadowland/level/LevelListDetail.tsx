import React, {useState} from 'react'
import {Level} from "../model/Level";
import Accordion from "react-bootstrap/Accordion";
import Card from "react-bootstrap/Card";

import Button from "react-bootstrap/Button";
import Modal from "react-bootstrap/Modal";
import Form from 'react-bootstrap/Form';
import {ShadowlandLevelType} from "../../../constants/ShadowlandLevelType";

import "./LevelListDetail.css"
import {ShadowlandFloorAdvantageType} from "../../../constants/ShadowlandFloorAdvantageType";

type levelListDetailProps = {
    levelList: Array<Level>,
    createLevel: (arg0: Level) => void,
    currentSelectedLevel: number,
    deleteLevel: (arg0: number) => void
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
            "floor_advantage": event.currentTarget.affinitySelect.value
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
                        />
                        <Form.Label>Level Type</Form.Label>
                        <Form.Control name="levelSelect" as="select" custom>
                            {ShadowlandLevelType.map((levelType, index) => {
                                return <option key={index} value={levelType.backend}>{levelType.description}</option>
                            })}
                        </Form.Control>

                        <Form.Label>Floor Advantage</Form.Label>
                        <Form.Control name="affinitySelect" as="select" custom>
                            {ShadowlandFloorAdvantageType.map((levelType, index) => {
                                return <option key={index} value={levelType.backend}>{levelType.description}</option>
                            })}
                        </Form.Control>


                        <Button className={"formButton"} variant="secondary" onClick={handleClose}>Close</Button>
                        <Button className={"formButton"} variant="primary" type="submit">Submit form</Button>
                    </Form>
                </Modal.Body>
            </Modal>
        )
    };

    const displayAccordion = (levelList: Array<Level>) => {
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
                                <AccordionDetail deleteLevel={props.deleteLevel} floorLevel={level} />
                            </Accordion.Collapse>
                        </Card>
                    )
                })}

            </Accordion>
        )
    }


    return (
        <div>
            {displayAccordion(props.levelList)}
            <Button onClick={handleShow}>Add New Level</Button>
            {addModal()}
        </div>
    )
}

export default LevelListDetail

type accordianDetailProps = {
    deleteLevel: (arg0: number) => void,
    floorLevel: Level
}

const AccordionDetail = (props: accordianDetailProps) => {
    return (
        <div>
            <Button onClick={() => {props.deleteLevel(props.floorLevel.id ? props.floorLevel.id : 0)}}>Delete</Button>
            <p>Use Again</p>
            <p>hold</p>
        </div>
    )
}