import React from 'react'

import {max, min} from "underscore"
import {Button} from "react-bootstrap";
import Form from "react-bootstrap/Form";
import {FaMinus, FaPlus} from 'react-icons/fa';

import './LevelList.css'

type levelListProps = {
    levelList: Array<number>,
    setLevel: (arg0: number) => void,
    currentLevel: number
}

const LevelList = (props: levelListProps) => {

    const handleChange = (event: React.ChangeEvent<HTMLInputElement | HTMLSelectElement | HTMLTextAreaElement>) => {
        let localCurrentLevel = parseInt(event.target.value)
        if (isNaN(localCurrentLevel)  || props.levelList.length === 0)
            return;
        if (localCurrentLevel > max(props.levelList) + 1){
            localCurrentLevel = max(props.levelList) + 1;
        }
        else if (localCurrentLevel <= 0){
            localCurrentLevel = min(props.levelList);
        }

        setLocalAndParentState(localCurrentLevel);

    }

    const removeOne = () => {
        let currentLevel = props.currentLevel;
        if (currentLevel === 0 || props.levelList.length === 0)
            return;

        let localCurrentLevel = --currentLevel;
        if (localCurrentLevel <= 0){
            localCurrentLevel = max(props.levelList) + 1;
        }
        setLocalAndParentState(localCurrentLevel);
    }

    const addOne = () => {
        let currentLevel = props.currentLevel;
        if (currentLevel === 0 || props.levelList.length === 0)
            return;

        let localCurrentLevel = ++currentLevel;
        if (localCurrentLevel > max(props.levelList) + 1){
            localCurrentLevel = min(props.levelList);
        }
        setLocalAndParentState(localCurrentLevel);
    }

    const setLocalAndParentState = (currentLevelProp: number) => {
        props.setLevel(currentLevelProp);
    }

    return (
            <div>
                <Form>
                    <div>
                        <Form.Label>Shadowland Level</Form.Label>
                        <Form.Row>
                            <Button onClick={addOne}><FaPlus/></Button>
                        </Form.Row>
                        <Form.Row>
                            <Form.Control
                                type="input"
                                onChange={(event) => handleChange(event)}
                                value={props.currentLevel}
                            />
                        </Form.Row>
                        <Form.Row>
                            <Button onClick={removeOne}><FaMinus/></Button>
                        </Form.Row>
                    </div>
                </Form>

            </div>

    )

}

export default LevelList;