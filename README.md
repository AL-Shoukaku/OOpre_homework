# OOpre第二次迭代作业
## 背景
这是一个冒险者游戏，通过输入符合规范的指令，来实现冒险者的各种操作，下面将介绍游戏的各种机制。
### 冒险者
冒险者的初始状态为:hp=500,attack=1,defend=0,mana=10。

冒险者可以拥有药水瓶和装备，可以学习法术。

冒险者拥有背包，可以将拥有的装备和药水瓶装入背包（携带操作）

冒险者可以对自己和其它冒险者使用物品，包括已装入背包的药水和学会的魔法，药水被使用后则丢弃。
### 药水瓶
药水瓶总共有4种，功能如下所示：
|类型type|意义|
|---|---|
HpBottle|体力恢复药水。若冒险者使用体力恢复药水，则目标增加数值为effect的体力。
AtkBottle|力量药水。若冒险者使用力量药水，则目标增加数值为 effect 的攻击力。
DefBottle|防御药水。若冒险者使用防御药水，则目标增加数值为effect 的防御力。
ManaBottle|魔力药水。若冒险者使用魔力药水，则目标增加数值为effect 的魔力值。
### 魔法
魔法分为攻击魔法和防御魔法两类
|类型type|意义|
|---|---|
HealSpell|治疗法术，若冒险者成功使用了治疗法术，则目标增加所使用法术 power 的 hitPoint 。
AttackSpell|攻击法术，若冒险者成功使用了攻击法术，则目标扣除所使用法术 power 的 hitPoint 。如果目标的hitpoint在被攻击后小于 0 ，则强制置为 0。

### 死亡机制
当一个冒险者的生命值为0时该冒险者死亡，任何涉及死亡冒险者的指令都被视为是异常指令

## 指令集
第一行输入整数n，表示后面要输入的指令个数。
|type|全称|attribute|意义|输出（每条对应的占一行）|
|---|---|---|---|---|
|aa|add adventurer|{adv_id}|添加一个 ID 为 {adv_id} 的冒险者|	无|
ab|add bottle|{adv_id} {bot_id} {type} {effect}|给 ID 为 {adv_id} 的冒险者增加一个药水瓶，药水瓶的 ID、类型、效果值分别为 {bot_id}、{type}、{effect}。 其中 {type} 是 HpBottle \ AtkBottle \ DefBottle \ ManaBottle 中其中一个|	无
ae|add equipment|{adv_id} {equ_id}|给 ID 为 {adv_id} 的冒险者添加一个 ID 为 {equ_id} 的装备|无
|ri|remove item|{adv_id} {item_id}|将 ID 为{adv_id}的冒险者的 id 为 {item_id} 的物品删除|	{一个字符串A}，字符串 A 为物品的类名（答案只能在以下类名中挑选其一： HpBottle、AtkBottle、DefBottle、ManaBottle、Equipment）
ti|take item|{adv_id} {item_id}|ID 为 {adv_id} 的冒险者尝试携带 id 为 {item_id} 的物品|{一个字符串A}，字符串 A 为物品的类名（答案只能在以下类名中挑选其一： HpBottle、AtkBottle、DefBottle、ManaBottle、Equipment）
use|use|{adv_id} {usable_id} {target_id}|ID 为 {adv_id} 的冒险者尝试对 {target_id} 使用他拥有的 id 为{usable_id}的可用物品|	成功：{一个字符串} {一个整数A} {一个整数B} {一个整数C} {一个整数D}，字符串为目标的 id，整数 A 为目标被作用后的体力值，整数 B 为目标被作用后的攻击力值，整数 C 为目标被作用后的防御力值 ，整数 D 为目标被作用后的魔力值。失败：输出 {adv_id} fail to use {usable_id}


## 数据限制
### 变量约束
|变量|类型|说明|
|---|---|---|
id|字符串|保证为仅包含大小写字母、数字与下划线的字符串，长度区间为 [1, 40]|
effect|整数|取值范围：0 - 2147483647
manaCost|整数|取值范围：1 - 2147483647
hitPoint|整数|取值范围：0 - 2147483647
atk|整数|取值范围：1 - 1073741823
def|整数|取值范围：0 - 1073741823
mana|整数|取值范围：0 - 2147483647
power|整数|取值范围：0 - 2147483647
- 注意，变量约束指的是，在程序运行时，输入和对应属性值始终均保证在表格中给出的范围内。

### 操作约束

- 保证所有添加的冒险者、药水瓶、装备、法术的 id 在全局范围内均不相同。
- 保证增加的冒险者、装备、药水瓶和法术在操作执行时，系统中原本不存在对应 id 的实体。
- 保证被删除的药水瓶/装备的 id 不会再次被用于添加新的药水瓶/装备/法术/冒险者。
- 对于 ab, ae, ls, ri, ti 指令，保证操作中指定的 {adv_id} 一定存在，但不保证其对应的冒险者存活。
- 对于 use 指令，保证操作中指定的 {adv_id} 和 {target_id} 一定存在，但不保证两者对应的冒险者存活。
- 对于 ri 和 ti 指令，保证冒险者一定拥有操作中指定 {item_id} 的药水瓶或装备。
- 对于 use 指令，保证冒险者一定拥有指定 {usable_id} 的药水瓶或法术。但如果 {usable_id} 对应的是药水瓶，则不保证冒险者一定携带了该药水瓶。
- 总操作数 n 满足 1 ≤ n ≤ 2000。