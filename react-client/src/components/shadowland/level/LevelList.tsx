import React, {useState} from 'react'

import {max, min} from "underscore"
import {Button} from "react-bootstrap";
import Form from "react-bootstrap/Form";
import {FaMinus, FaPlus} from 'react-icons/fa';

import './LevelList.css'

type levelListProps = {
    levelList: Array<number>,
    setLevel: (arg0: number) => void
}

const LevelList = (props: levelListProps) => {

    const [modifiedLevel, setModifiedLevel] = useState({
        currentLevel: props.levelList ? props.levelList[0] : 0 });

    const handleChange = (event: React.ChangeEvent<HTMLInputElement | HTMLSelectElement | HTMLTextAreaElement>) => {
        let localCurrentLevel = parseInt(event.target.value)
        if (isNaN(localCurrentLevel))
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
        if (modifiedLevel.currentLevel === 0)
            return;

        let localCurrentLevel = --modifiedLevel.currentLevel;
        if (localCurrentLevel <= 0){
            localCurrentLevel = max(props.levelList) + 1;
        }
        setLocalAndParentState(localCurrentLevel);
    }

    const addOne = () => {
        if (modifiedLevel.currentLevel === 0)
            return;

        let localCurrentLevel = ++modifiedLevel.currentLevel;
        if (localCurrentLevel > max(props.levelList) + 1){
            localCurrentLevel = min(props.levelList);
        }
        setLocalAndParentState(localCurrentLevel);
    }

    const setLocalAndParentState = (currentLevel: number) => {
        setModifiedLevel({currentLevel: currentLevel})
        props.setLevel(currentLevel);

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
                            value={modifiedLevel.currentLevel}
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